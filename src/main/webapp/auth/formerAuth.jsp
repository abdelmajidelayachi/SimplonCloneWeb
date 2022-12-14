<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
   <jsp:include page="/component/impots.jsp"/>
</head>

<!-- component -->
<body class="antialiased bg-gradient-to-br from-green-100 to-white relative -z-20">
<div class="relative h-screen -z-10 w-full overflow-hidden">
    <img src="${pageContext.request.contextPath}/assets/images/bg/bg3.jpg" class="" alt="bg">
</div>
<div class="absolute z-50 top-0 container px-6 mx-auto">
    <div
            class="flex flex-col text-center md:text-left md:flex-row h-screen justify-evenly md:items-center"
    >
        <div class="flex flex-col w-full">
            <div>
                <svg
                        class="w-20 h-20 mx-auto md:float-left fill-stroke text-gray-800"
                        fill="none"
                        stroke="currentColor"
                        viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            stroke-width="2"
                            d="M12 6V4m0 2a2 2 0 100 4m0-4a2 2 0 110 4m-6 8a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4m6 6v10m6-2a2 2 0 100-4m0 4a2 2 0 110-4m0 4v2m0-6V4"
                    ></path>
                </svg>
            </div>
            <h1 class="text-5xl text-gray-800 font-bold">Client Area</h1>
            <p class="w-5/12 mx-auto md:mx-0 text-gray-500">
                Control and monitorize your website data from dashboard.
            </p>
        </div>
        <div class="w-full md:w-full lg:w-9/12 mx-auto md:mx-0">
            <div class="bg-white p-10 flex flex-col w-full shadow-xl rounded-xl">
                <h2 class="text-2xl font-bold text-gray-800 text-left mb-5">
                    Sign in
                </h2>
                <form action="/former/home" class="w-full">
                    <div id="container-username" class="flex flex-col w-full my-5">
                        <label for="email" class="text-gray-500 mb-2"
                        >Email</label
                        >
                        <input
                                type="email" name="email"
                                id="email"
                                placeholder="Please insert your email"
                                class="appearance-none border-2 border-gray-100 rounded-lg px-4 py-3 placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-green-600 focus:shadow-lg"
                        />
                    </div>
                    <div id="input" class="flex flex-col w-full my-5">
                        <label for="password" class="text-gray-500 mb-2"
                        >Password</label
                        >
                        <input
                                type="password"
                                id="password"
                                name="password"
                                placeholder="Please insert your password"
                                class="appearance-none border-2 border-gray-100 rounded-lg px-4 py-3 placeholder-gray-300 focus:outline-none focus:ring-2 focus:ring-green-600 focus:shadow-lg"
                        />
                    </div>
                    <div id="button" class="flex flex-col w-full my-5">
                        <button
                                type="submit"
                                class="w-full py-4 bg-red-600 rounded-lg text-red-50"
                        >
                            <div class="flex flex-row items-center justify-center">
                                <div class="mr-2">
                                    <svg
                                            class="w-6 h-6"
                                            fill="none"
                                            stroke="currentColor"
                                            viewBox="0 0 24 24"
                                            xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                                stroke-linecap="round"
                                                stroke-linejoin="round"
                                                stroke-width="2"
                                                d="M11 16l-4-4m0 0l4-4m-4 4h14m-5 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h7a3 3 0 013 3v1"
                                        ></path>
                                    </svg>
                                </div>
                                <div class="font-bold">Sigin</div>
                            </div>
                        </button>
                        <div class="flex justify-evenly mt-5">
                            <a
                                    href="#"
                                    class="w-full text-center font-medium text-gray-500"
                            >Recover password!</a
                            >

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>