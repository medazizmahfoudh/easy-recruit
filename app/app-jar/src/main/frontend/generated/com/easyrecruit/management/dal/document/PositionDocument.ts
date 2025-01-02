import type Skill_1 from "../../infra/model/entity/Skill.js";
interface PositionDocument {
    id?: string;
    uuid?: string;
    name?: string;
    description?: string;
    location?: string;
    requiredSkillSet?: Array<Skill_1 | undefined>;
}
export default PositionDocument;
