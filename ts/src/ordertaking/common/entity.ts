type RawId = string | number | bigint;

export abstract class Entity<ID extends RawId | ValueObject> implements Equatable {
    abstract readonly id: ID;
    protected abstract isSameClass<T extends Entity<ID>>(obj: unknown): obj is T;

    @bound
    equals(obj: unknown): boolean {
        if (!this.isSameClass(obj)) return false;
        const otherId = (obj as Entity<ID>).id;

        return this.id instanceof ValueObject
        ? this.id.equals(otherId)
            : this.id === otherId;
    }
}