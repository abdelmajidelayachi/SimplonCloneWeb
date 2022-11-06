<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
        integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V"
        crossorigin="anonymous"
/>
<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
<link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css"/>
<div class="min-h-full">
    <nav class="bg-red-600">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div class="flex items-center justify-between h-16">
                <div class="flex items-center">
                    <div class="flex-shrink-0 bg-white p-4">
                        <svg width="34" height="34" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" class="text-red-600 w-10 h-10"><path d="M20.335,3.905C22.609,6.179 23.76,8.909 23.76,12.066C23.76,15.25 22.609,17.953 20.335,20.227C18.061,22.502 15.278,23.652 11.987,23.652C8.722,23.652 5.939,22.502 3.665,20.227C1.391,17.953 0.24,15.223 0.24,12.066C0.24,8.909 1.391,6.206 3.665,3.905C5.939,1.631 8.722,0.48 11.987,0.48C15.278,0.48 18.061,1.631 20.335,3.905ZM11.987,2.968C9.578,2.968 7.491,3.851 5.725,5.617C3.959,7.383 3.076,9.524 3.076,12.066C3.076,14.608 3.959,16.775 5.725,18.541C7.491,20.307 9.578,21.19 11.987,21.19C14.395,21.19 16.482,20.307 18.248,18.541C20.014,16.775 20.897,14.635 20.897,12.066C20.897,9.524 20.014,7.383 18.248,5.617C16.482,3.851 14.395,2.968 11.987,2.968Z" fill="currentColor" class="colorFill"></path><path d="M13.726,7.25L10.274,7.25L10.274,10.701L13.726,10.701L13.726,7.25ZM13.726,13.404L10.274,13.404L10.274,16.856L13.726,16.856L13.726,13.404Z" fill="currentColor" class="colorFill"></path></svg>
                    </div>
                    <div class="hidden md:block">
                        <div class="ml-10 flex items-baseline space-x-4">
                            <!-- Current: "bg-red-700 text-white", Default: "text-white hover:bg-red-500 hover:bg-opacity-75" -->
                            <c:set var = "current" value ="${param.currentPage}"/>
                            <c:choose>
                                <c:when test="${current == 'former'}">
                                    <a href="${pageContext.request.contextPath}/admin/formers"
                                       class="bg-red-700 text-white px-3 py-2 rounded-md text-sm font-medium">Formers
                                    </a>

                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/admin/formers"
                                       class="text-white hover:bg-red-500 hover:bg-opacity-75 px-3 py-2 rounded-md text-sm font-medium">Formers
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${current == 'learner'}">
                                    <a href="${pageContext.request.contextPath}/admin/learners"
                                       class="bg-red-700 text-white px-3 py-2 rounded-md text-sm font-medium">Learner
                                    </a>

                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/admin/learners"
                                       class="text-white hover:bg-red-500 hover:bg-opacity-75 px-3 py-2 rounded-md text-sm font-medium">Learner
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${current == 'promo'}">
                                    <a href="${pageContext.request.contextPath}/admin/promos"
                                       class="bg-red-700 text-white px-3 py-2 rounded-md text-sm font-medium">Promos
                                    </a>

                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/admin/promos"
                                       class="text-white hover:bg-red-500 hover:bg-opacity-75 px-3 py-2 rounded-md text-sm font-medium">Promos
                                    </a>
                                </c:otherwise>
                            </c:choose>

                         </div>
                    </div>
                </div>
                <div class="hidden md:block">
                    <div class="ml-4 flex items-center md:ml-6">
                        <button type="button"
                                class="p-1 bg-red-600 rounded-full text-red-200 hover:text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-red-600 focus:ring-white">
                            <span class="sr-only">View notifications</span>
                            <!-- Heroicon name: outline/bell -->
                            <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                 stroke="currentColor" aria-hidden="true">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                      d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"></path>
                            </svg>
                        </button>

                        <!-- Profile dropdown -->
                        <div class="ml-3 relative">
                            <div>
                                <button type="button"
                                        class="max-w-xs bg-red-600 rounded-full flex items-center text-sm focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-red-600 focus:ring-white"
                                        id="user-menu-button" aria-expanded="false" aria-haspopup="true">
                                    <span class="sr-only">Open user menu</span>
                                    <img class="h-8 w-8 rounded-full"
                                         src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                                         alt="">
                                </button>
                            </div>

                            <!--
                              Dropdown menu, show/hide based on menu state.

                              Entering: "transition ease-out duration-100"
                                From: "transform opacity-0 scale-95"
                                To: "transform opacity-100 scale-100"
                              Leaving: "transition ease-in duration-75"
                                From: "transform opacity-100 scale-100"
                                To: "transform opacity-0 scale-95"
                            -->
                            <div class="hidden origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg py-1 bg-white ring-1 ring-black ring-opacity-5 focus:outline-none"
                                 role="menu" aria-orientation="vertical" aria-labelledby="user-menu-button"
                                 tabindex="-1">
                                <!-- Active: "bg-gray-100", Not Active: "" -->
                                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1"
                                   id="user-menu-item-0">Your Profile</a>

                                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1"
                                   id="user-menu-item-1">Settings</a>

                                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1"
                                   id="user-menu-item-2">Sign out</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="-mr-2 flex md:hidden">
                    <!-- Mobile menu button -->
                    <button type="button"
                            class="bg-red-600 inline-flex items-center justify-center p-2 rounded-md text-red-200 hover:text-white hover:bg-red-500 hover:bg-opacity-75 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-red-600 focus:ring-white"
                            aria-controls="mobile-menu" aria-expanded="false">
                        <span class="sr-only">Open main menu</span>
                        <!--
                          Heroicon name: outline/menu

                          Menu open: "hidden", Menu closed: "block"
                        -->
                        <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M4 6h16M4 12h16M4 18h16"></path>
                        </svg>
                        <!--
                          Heroicon name: outline/x

                          Menu open: "block", Menu closed: "hidden"
                        -->
                        <svg class="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M6 18L18 6M6 6l12 12"></path>
                        </svg>
                    </button>
                </div>
            </div>
        </div>

        <!-- Mobile menu, show/hide based on menu state. -->
        <div class="md:hidden" id="mobile-menu">
            <div class="px-2 pt-2 pb-3 space-y-1 sm:px-3">
                <!-- Current: "bg-red-700 text-white", Default: "text-white hover:bg-red-500 hover:bg-opacity-75" -->
                <a href="#" class="bg-red-700 text-white block px-3 py-2 rounded-md text-base font-medium"
                   aria-current="page">Formers</a>


                <a href="#"
                   class="text-white hover:bg-red-500 hover:bg-opacity-75 block px-3 py-2 rounded-md text-base font-medium">Learners</a>

                <a href="#"
                   class="text-white hover:bg-red-500 hover:bg-opacity-75 block px-3 py-2 rounded-md text-base font-medium">Promos</a>

            </div>
            <div class="pt-4 pb-3 border-t border-red-700">
                <div class="flex items-center px-5">
                    <div class="flex-shrink-0">
                        <img class="h-10 w-10 rounded-full"
                             src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80"
                             alt="">
                    </div>
                    <div class="ml-3">
                        <div class="text-base font-medium text-white">Tom Cook</div>
                        <div class="text-sm font-medium text-red-300">tom@example.com</div>
                    </div>
                    <button type="button"
                            class="ml-auto bg-red-600 flex-shrink-0 p-1 rounded-full text-red-200 hover:text-white focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-red-600 focus:ring-white">
                        <span class="sr-only">View notifications</span>
                        <!-- Heroicon name: outline/bell -->
                        <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                             stroke="currentColor" aria-hidden="true">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                  d="M15 17h5l-1.405-1.405A2.032 2.032 0 0118 14.158V11a6.002 6.002 0 00-4-5.659V5a2 2 0 10-4 0v.341C7.67 6.165 6 8.388 6 11v3.159c0 .538-.214 1.055-.595 1.436L4 17h5m6 0v1a3 3 0 11-6 0v-1m6 0H9"></path>
                        </svg>
                    </button>
                </div>
                <div class="mt-3 px-2 space-y-1">
                    <a href="#"
                       class="block px-3 py-2 rounded-md text-base font-medium text-white hover:bg-red-500 hover:bg-opacity-75">Your
                        Profile</a>

                    <a href="#"
                       class="block px-3 py-2 rounded-md text-base font-medium text-white hover:bg-red-500 hover:bg-opacity-75">Settings</a>

                    <a href="#"
                       class="block px-3 py-2 rounded-md text-base font-medium text-white hover:bg-red-500 hover:bg-opacity-75">Sign
                        out</a>
                </div>
            </div>
        </div>
    </nav>


