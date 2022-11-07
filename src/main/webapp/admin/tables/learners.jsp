<%@ page import="java.util.List" %>
<%@ page import="com.simploncloneweb.simplon_clone_web.entities.LearnersEntity" %>
<header class="bg-white shadow-sm">
  <div class="max-w-7xl mx-auto py-4 px-4 sm:px-6 lg:px-8">
    <h1 class="text-lg leading-6 font-semibold text-gray-900">Learners</h1>
  </div>
</header>
<main>
  <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
    <!-- Replace with your content -->
    <div class="px-4 py-4 sm:px-0">
      <!-- component -->
      <div class="bg-white p-8 rounded-md w-full">
        <div class=" flex items-center w-full pb-6">

          <div class="flex items-center w-full  justify-between">
            <div class="flex bg-gray-50 items-center p-2 rounded-md">
              <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20"
                   fill="currentColor">
                <path fill-rule="evenodd"
                      d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                      clip-rule="evenodd"></path>
              </svg>
              <label for="search"><input class="bg-gray-50 outline-none border-none ml-1 block " type="search" name="search" id="search" placeholder="search..."></label>
            </div>
            <div class="lg:ml-40 ml-10 space-x-8">
              <button type="button" onclick="openModal()" class="bg-indigo-600 px-4 py-2 rounded-md text-white font-semibold tracking-wide cursor-pointer">Create</button>
            </div>
          </div>
        </div>
        <div>
          <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">
            <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
              <table class="min-w-full leading-normal">
                <thead>
                <tr>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Full Name
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Email
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Promo
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Created At
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Action
                  </th>
                </tr>
                </thead>
                <tbody>
                <% List<LearnersEntity> learners = (List<LearnersEntity>) request.getAttribute("learners");
                  if (learners != null) {

                  for (LearnersEntity learner: learners) { %>

                <tr id="row-text-<%=learner.getIdLearner()%>" class="w-full">
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <div class="flex items-center">
                      <div class="flex-shrink-0 w-10 h-10">
                        <img class="w-full h-full rounded-full"
                             src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2.2&w=160&h=160&q=80"
                             alt="" />
                      </div>
                      <div class="ml-3">
                        <p class="text-gray-900 whitespace-no-wrap">
                          <%=learner.getFirstName()+" "+learner.getLastName()%>
                        </p>
                      </div>

                    </div>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap"> <%=learner.getEmail()%></p>

                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap">
                     gvtyvv
                    </p>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap">
                     <%--<% SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");%>
                      <%= DateFor.format(learner.getCreatedAt()) %>--%>
                       06/11/2022
                    </p>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <%--open edit learner form--%>
                    <button type="button" onclick="editFormOpen(<%=learner.getIdLearner()%>)"
                    class="w-5 mr-3  transform hover:text-secondary-green hover:scale-110"
                    >
                    <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke="currentColor"
                    >
                      <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          stroke-width="2"
                          d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z"
                      ></path>
                    </svg>
                    </button>
                    <button
                    class="w-5 transform text-red-500 hover:text-secondary-green hover:scale-110"
                    >
                      <a href="/admin/learner/delete?idLearner=<%=learner.getIdLearner()%>">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                    >
                      <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          stroke-width="2"
                          d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"></path>
                    </svg>
                      </a>
                    </button>
                  </td>
                  <td>
                    <jsp:include page="../modals/edit.jsp">
                      <jsp:param name="target" value="learner"/>
                      <jsp:param name="id" value="<%=learner.getIdLearner()%>"/>
                      <jsp:param name="firstname" value="<%=learner.getFirstName()%>"/>
                      <jsp:param name="lastname" value="<%=learner.getLastName()%>"/>
                      <jsp:param name="email" value="<%=learner.getEmail()%>"/>
                    </jsp:include>
                  </td>
                </tr>
                <%--update learner form--%>

                <%}}%>

                </tbody>
              </table>
              <div
                  class="px-5 py-5 bg-white border-t flex flex-col xs:flex-row items-center xs:justify-between          ">
                    <span class="text-xs xs:text-sm text-gray-900">
                        Showing 1 to 4 of 50 Entries
                    </span>
                <div class="inline-flex mt-2 xs:mt-0">
                  <button
                          class="text-sm text-indigo-50 transition duration-150 hover:bg-indigo-500 bg-indigo-600 font-semibold py-2 px-4 rounded-l">
                    Prev
                  </button>
                  &nbsp; &nbsp;
                  <button
                          class="text-sm text-indigo-50 transition duration-150 hover:bg-indigo-500 bg-indigo-600 font-semibold py-2 px-4 rounded-r">
                    Next
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- /End replace -->
  </div>
</main>
