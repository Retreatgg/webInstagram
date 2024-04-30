<#import "layout.ftlh" as main>
<#import "spring.ftl" as spring>
<@main.layout>
    <style>

    </style>
    <section>

        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body p-5">
                                <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                                <form action="/auth/register" method="post">

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1cg">Your Name</label>
                                        <@spring.formInput "userDto.name" 'id="form3Example1cg" class="form-control form-control-lg"'/>

                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example2cg">Your Username</label>
                                        <@spring.formInput "userDto.username" 'id="form3Example2cg" class="form-control form-control-lg"'/>

                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example3cg">Your Email</label>
                                        <@spring.formInput "userDto.email" 'id="form3Example3cg" class="form-control form-control-lg"'/>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">About Info</label>
                                        <@spring.formInput "userDto.aboutInfo" 'id="form3Example4cg" class="form-control form-control-lg"'/>
                                    </div>

                                    <div data-mdb-input-init class="form-outline mb-4">
                                        <label class="form-label" for="form3Example4cg">Password</label>
                                        <@spring.formPasswordInput "userDto.password" 'id="form3Example4cg" class="form-control form-control-lg"'/>
                                        <@spring.showErrors "<br>" "error text-danger" />
                                    </div>

                                    <div class="d-flex justify-content-center">
                                        <button type="submit"
                                                data-mdb-button-init
                                                data-mdb-ripple-init
                                                class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">
                                            Register
                                        </button>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</@main.layout>