import * as E from 'fp-ts/Either'

export type ErrNumberLessThanMin = { readonly _tag: 'ErrNumberLessThanMin'; readonly min: number }
export type ErrNumberGreaterThanMax = { readonly _tag: 'ErrNumberGreaterThanMax'; readonly max: number }
export type ErrInvalidFormat = { readonly _tag: 'ErrInvalidFormat'; readonly pattern: string }

export type ErrPrimitiveConstraints =
    | ErrNumberLessThanMin
    | ErrNumberGreaterThanMax
    | ErrInvalidFormat

export const errNumberLessThanMin = (min: number): ErrNumberLessThanMin =>
    ({ _tag: 'ErrNumberLessThanMin', min })

export const errNumberGreaterThanMax = (max: number): ErrNumberGreaterThanMax =>
    ({ _tag: 'ErrNumberGreaterThanMax', max })

export const errInvalidFormat = (pattern: string): ErrInvalidFormat =>
    ({ _tag: 'ErrInvalidFormat', pattern })