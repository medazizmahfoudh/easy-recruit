import { _getPropertyModel as _getPropertyModel_1, makeObjectEmptyValueCreator as makeObjectEmptyValueCreator_1, NumberModel as NumberModel_1, ObjectModel as ObjectModel_1, StringModel as StringModel_1 } from "@vaadin/hilla-lit-form";
import ApplicationStatusModel_1 from "../../infra/model/entity/ApplicationStatusModel.js";
import CandidateModel_1 from "../../infra/model/entity/CandidateModel.js";
import type ApplicationEntity_1 from "./ApplicationEntity.js";
class ApplicationEntityModel<T extends ApplicationEntity_1 = ApplicationEntity_1> extends ObjectModel_1<T> {
    static override createEmptyValue = makeObjectEmptyValueCreator_1(ApplicationEntityModel);
    get id(): NumberModel_1 {
        return this[_getPropertyModel_1]("id", (parent, key) => new NumberModel_1(parent, key, true, { meta: { annotations: [{ name: "jakarta.persistence.Id" }], javaType: "java.lang.Long" } }));
    }
    get uuid(): StringModel_1 {
        return this[_getPropertyModel_1]("uuid", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get cvUuid(): StringModel_1 {
        return this[_getPropertyModel_1]("cvUuid", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get positionUuid(): StringModel_1 {
        return this[_getPropertyModel_1]("positionUuid", (parent, key) => new StringModel_1(parent, key, true, { meta: { javaType: "java.lang.String" } }));
    }
    get candidate(): CandidateModel_1 {
        return this[_getPropertyModel_1]("candidate", (parent, key) => new CandidateModel_1(parent, key, true));
    }
    get status(): ApplicationStatusModel_1 {
        return this[_getPropertyModel_1]("status", (parent, key) => new ApplicationStatusModel_1(parent, key, true));
    }
}
export default ApplicationEntityModel;
