import { _enum as _enum_1, EnumModel as EnumModel_1, makeEnumEmptyValueCreator as makeEnumEmptyValueCreator_1 } from "@vaadin/hilla-lit-form";
import ApplicationStatus_1 from "./ApplicationStatus.js";
class ApplicationStatusModel extends EnumModel_1<typeof ApplicationStatus_1> {
    static override createEmptyValue = makeEnumEmptyValueCreator_1(ApplicationStatusModel);
    readonly [_enum_1] = ApplicationStatus_1;
}
export default ApplicationStatusModel;
