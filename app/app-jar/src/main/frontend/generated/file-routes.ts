import type { AgnosticRoute } from "@vaadin/hilla-file-router/types.js";
import { createRoute } from "@vaadin/hilla-file-router/runtime.js";
import * as Page0 from "../views/@index.js";
import * as Page1 from "../views/auth/login.js";
import * as Page2 from "../views/auth/signup.js";
import * as Page4 from "../views/dashboard/main.js";
const routes: readonly AgnosticRoute[] = [
    createRoute("", false, Page0),
    createRoute("auth", false, [
        createRoute("login", false, Page1),
        createRoute("signup", false, Page2)
    ]),
    createRoute("dashboard", false, [
        createRoute("main", false, Page4)
    ])
];
export default routes;
