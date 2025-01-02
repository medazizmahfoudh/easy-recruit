import {Button, EmailField, FormLayout, PasswordField} from "@vaadin/react-components";

export default function Login() {
    const responsiveSteps = [
        { minWidth: '0', columns: 1 },
    ];

    return (
        <section className="flex h-screen justify-center items-center">
            <div className="flex-column">
                <div>
                    <h1 className="text-4xl font-bold">Login</h1>
                    <p>Dont have an account? <a href="/auth/signup" className="text-blue-500">Sign up</a></p>
                </div>
                <div>
                    <FormLayout responsiveSteps={responsiveSteps} className="max-w-screen-sm">
                        <EmailField label="Email"/>
                        <PasswordField label="Password"/>
                        <Button theme="primary" className="mt-m">Sign up</Button>
                    </FormLayout>
                </div>
            </div>
        </section>
    );
}