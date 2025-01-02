import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import type ApplicationEntity_1 from "./com/easyrecruit/management/dal/entity/ApplicationEntity.js";
import client_1 from "./connect-client.default.js";
async function findAll_1(init?: EndpointRequestInit_1): Promise<Array<ApplicationEntity_1>> { return client_1.call("ApplicationService", "findAll", {}, init); }
export { findAll_1 as findAll };
