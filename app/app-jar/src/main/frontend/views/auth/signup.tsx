import {Button, EmailField, FormLayout, PasswordField, TextField} from "@vaadin/react-components";

export default function SignUp() {
    const responsiveSteps = [
        { minWidth: '0', columns: 1 },
    ];

    return (
        <section className="flex h-screen justify-center items-center">
        <div className="flex-column">
            <div>
                <h1 className="text-4xl font-bold">Sign up</h1>
                <p>Already have an account? <a href="/auth/login" className="text-blue-500">Login</a></p>
            </div>
            <div>
                <FormLayout responsiveSteps={responsiveSteps} className="max-w-screen-sm">
                    <TextField label="First name" />
                    <TextField label="Last name" />
                    <EmailField label="Email" />
                    <PasswordField label="Password" />
                    <PasswordField label="Confirm password" />
                    <Button theme="primary" className="mt-m">Sign up</Button>
                </FormLayout>
            </div>
        </div>
        </section>
            );
}