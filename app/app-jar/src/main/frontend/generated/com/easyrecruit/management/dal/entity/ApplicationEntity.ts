import type ApplicationStatus_1 from "../../infra/model/entity/ApplicationStatus.js";
import type Candidate_1 from "../../infra/model/entity/Candidate.js";
interface ApplicationEntity {
    id?: number;
    uuid?: string;
    cvUuid?: string;
    positionUuid?: string;
    candidate?: Candidate_1;
    status?: ApplicationStatus_1;
}
export default ApplicationEntity;
