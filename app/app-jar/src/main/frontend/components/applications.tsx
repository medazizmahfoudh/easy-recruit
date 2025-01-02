import {useEffect, useState} from "react";
import ApplicationEntity from "Frontend/generated/com/easyrecruit/management/dal/entity/ApplicationEntity";
import {ApplicationService} from "Frontend/generated/endpoints";
import {Grid, GridColumn} from "@vaadin/react-components";

export default function Applications() {

    const [applications, setApplications] = useState<ApplicationEntity[]>([]);
    const [positions, setPositions] = useState<any>([]);

    useEffect(() => {
        ApplicationService.findAll().then(setApplications);
    }, []);

    return (
        <div>
            <Grid items={applications} >
                <GridColumn path="status"/>
                <GridColumn path="candidate.firstname" />
                <GridColumn path="candidate.lastname" />
                <GridColumn path="candidate.email" />
            </Grid>

        </div>
    )
}