import {Button, TabSheet, TabSheetTab} from "@vaadin/react-components";
import Interviews from "Frontend/components/interviews";
import Candidates from "Frontend/components/candidates";
import Applications from "Frontend/components/applications";

export default function Main() {

    return (
        <section className="flex-column gap-m p-xl">
            <nav className="flex justify-between px-l mb-l">
                <div>
                    <h1>Easy Recruit</h1>
                    <span>Mohamed Aziz Mahfoudh • <span className="font-bold">ADMIN</span></span>

                </div>
                <div>
                <Button theme="primary">Log out</Button>
                </div>
            </nav>
            <div>
                <TabSheet>
                    <TabSheetTab label="Dashboard">
                    </TabSheetTab>
                    <TabSheetTab label="Applications">
                        <Applications />
                    </TabSheetTab>
                    <TabSheetTab label="Interviews">
                        <Interviews />
                    </TabSheetTab>
                    <TabSheetTab label="Candidates">
                        <Candidates />
                    </TabSheetTab>
                </TabSheet>
                <div>
                </div>
            </div>
        </section>
    )
}