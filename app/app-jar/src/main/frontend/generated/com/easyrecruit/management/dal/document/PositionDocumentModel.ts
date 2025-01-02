import { _getPropertyModel as _getPropertyModel_1, ArrayModel as ArrayModel_1, makeObjectEmptyValueCreator as makeObjectEmptyValueCreator_1, ObjectModel as ObjectModel_1, StringModel as StringModel_1 } from "@vaadin/hilla-lit-form";
import SkillModel_1 from "../../infra/model/entity/SkillModel.js";
import type PositionDocument_1 from "./PositionDocument.js";
class PositionDocumentModel<T extends PositionDocument_1 = PositionDocument_1> extends ObjectModel_1<T> {
    static override createEmptyValue = makeObjectEmptyValueCreator_1(PositionDocumentModel);
    get id(): StringModel_1 {
        return this[_getPropertyModel_1]("id", (parent, key) => new StringModel_1(parent, key, true, { meta: { annotations: [{ name: "jakarta.persistence.Id" }], javaType: "java.lang.String" } }));
    }
    get uuid(): StringModel_1 {
        return this[_getPropertyModel_1]("uuid", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get name(): StringModel_1 {
        return this[_getPropertyModel_1]("name", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get description(): StringModel_1 {
        return this[_getPropertyModel_1]("description", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get location(): StringModel_1 {
        return this[_getPropertyModel_1]("location", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get requiredSkillSet(): ArrayModel_1<SkillModel_1> {
        return this[_getPropertyModel_1]("requiredSkillSet", (parent, key) => new ArrayModel_1(parent, key, true, (parent, key) => new SkillModel_1(parent, key, true), { meta: { javaType: "java.util.Set" } }));
    }
}
export default PositionDocumentModel;
