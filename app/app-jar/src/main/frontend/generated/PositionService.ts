import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import type PositionDocument_1 from "./com/easyrecruit/management/dal/document/PositionDocument.js";
import client_1 from "./connect-client.default.js";
async function findAll_1(init?: EndpointRequestInit_1): Promise<Array<PositionDocument_1>> { return client_1.call("PositionService", "findAll", {}, init); }
export { findAll_1 as findAll };
