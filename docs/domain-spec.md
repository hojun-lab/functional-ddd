컨텍스트: 주문 처리 (Order-Taking)

// ---
// 단순 타입 (Simple Types)
// 도메인의 기본 개념을 타입으로 표현
// ---

// 상품 코드
data ProductCode = WidgetCode OR GizmoCode
data WidgetCode = "W"로 시작하는 4자리 숫자 문자열  // 예: "W1234"
data GizmoCode  = "G"로 시작하는 3자리 문자열       // 예: "G123"

// 주문 수량
data OrderQuantity = UnitQuantity OR KilogramQuantity
data UnitQuantity      = 1 이상 1000 이하의 정수
data KilogramQuantity  = 0.05 이상 100.0 이하의 소수

// 기본 원시 타입 래퍼 (제약을 타입으로 문서화)
data String50      = 최대 50자의 문자열
data EmailAddress  = "@"를 포함하는 유효한 이메일 문자열
data ZipCode       = 5자리 숫자 문자열
data OrderId       = 문자열
data OrderLineId   = 문자열
data Price         = 0.0 이상 1000.0 이하의 소수
data BillingAmount = 0.0 이상 10000.0 이하의 소수

// ---
// 값 객체 (Value Objects)
// 식별자 없이 속성으로만 동등성이 결정되는 객체
// ---

data PersonalName =
    FirstName : String50
    AND LastName : String50

data CustomerInfo =
    Name         : PersonalName
    AND EmailAddress : EmailAddress

data Address =
    AddressLine1 : String50
    AND AddressLine2 : String50 option
    AND AddressLine3 : String50 option
    AND AddressLine4 : String50 option
    AND City         : String50
    AND ZipCode      : ZipCode

// ---
// 주문 생명주기 (Order Life Cycle)
// 각 상태는 별도의 타입으로 표현 → 잘못된 상태는 표현 불가
// ---

// --- 미검증 상태 ---
// 외부에서 들어온 원시 데이터, 아직 검증되지 않음
data UnvalidatedOrder =
    OrderId          : string
    AND CustomerInfo     : UnvalidatedCustomerInfo
    AND ShippingAddress  : UnvalidatedAddress
    AND BillingAddress   : UnvalidatedAddress
    AND Lines            : list of UnvalidatedOrderLine

data UnvalidatedCustomerInfo =
    FirstName    : string
    AND LastName     : string
    AND EmailAddress : string

data UnvalidatedAddress =
    AddressLine1 : string
    AND AddressLine2 : string
    AND AddressLine3 : string
    AND AddressLine4 : string
    AND City         : string
    AND ZipCode      : string

data UnvalidatedOrderLine =
    OrderLineId  : string
    AND ProductCode  : string
    AND Quantity     : decimal

// --- 검증 완료 상태 ---
// 검증을 통과한 데이터, 도메인 타입으로 변환됨
data ValidatedOrder =
    OrderId         : OrderId
    AND CustomerInfo    : CustomerInfo
    AND ShippingAddress : Address
    AND BillingAddress  : Address
    AND Lines           : list of ValidatedOrderLine

data ValidatedOrderLine =
    OrderLineId  : OrderLineId
    AND ProductCode  : ProductCode
    AND Quantity     : OrderQuantity

// --- 가격 산정 완료 상태 ---
// 각 라인에 가격이 책정되고 총 청구 금액이 계산됨
data PricedOrder =
    OrderId         : OrderId
    AND CustomerInfo    : CustomerInfo
    AND ShippingAddress : Address
    AND BillingAddress  : Address
    AND Lines           : list of PricedOrderLine
    AND AmountToBill    : BillingAmount

data PricedOrderLine =
    OrderLineId  : OrderLineId
    AND ProductCode  : ProductCode
    AND Quantity     : OrderQuantity
    AND LinePrice    : Price

// --- 출력 이벤트 (Output Events) ---
// 워크플로 완료 시 발행되는 도메인 이벤트
data OrderAcknowledgmentSent =
    OrderId      : OrderId
    AND EmailAddress : EmailAddress

data OrderPlaced = PricedOrder  // 배송팀으로 전달

data BillableOrderPlaced =
    OrderId        : OrderId
    AND BillingAddress : Address
    AND AmountToBill   : BillingAmount

// ---
// 에러 타입 (Error Types)
// ---

data ValidationError =
    FieldName    : string
    AND ErrorDescription : string

data PlaceOrderError =
    Validation  : ValidationError list
    OR Pricing  : PricingError

// ---
// 워크플로 (Workflows)
// 입력 → 처리 → 출력 이벤트 목록
// ---

workflow "주문 접수" =
    input: UnvalidatedOrder
    output (성공 시):
        OrderAcknowledgmentSent       // 고객에게 확인 이메일
        AND OrderPlaced               // 배송팀으로 전달
        AND BillableOrderPlaced       // 청구팀으로 전달
    output (실패 시):
        PlaceOrderError

// ---
// 하위 단계 (Substeps)
// 워크플로를 구성하는 순수 함수들
// ---

substep "주문 검증" =
    input: UnvalidatedOrder
    output (성공 시): ValidatedOrder
    output (실패 시): ValidationError list

substep "주문 가격 산정" =
    input: ValidatedOrder
    output (성공 시): PricedOrder
    output (실패 시): PricingError

substep "주문 확인 발송" =
    input: PricedOrder
    output: OrderAcknowledgmentSent option  // 발송 실패해도 워크플로는 계속

substep "이벤트 생성" =
    input: PricedOrder
    input: OrderAcknowledgmentSent option
    output: PlaceOrderEvent list