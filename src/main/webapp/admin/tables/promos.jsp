<%@ page import="java.util.List" %>
<%@ page import="com.simploncloneweb.simplon_clone_web.entities.LearnersEntity" %>
<%@ page import="com.simploncloneweb.simplon_clone_web.entities.PromosEntity" %>
<%@ page import="com.simploncloneweb.simplon_clone_web.entities.FormersEntity" %>
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
                    Promo Name
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Description
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Campus
                  </th>
                  <th
                          class="px-5 py-3 border-b-2 border-gray-200 bg-gray-100 text-left text-xs font-semibold text-gray-600 uppercase tracking-wider">
                    Former
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
                <% List<PromosEntity> promos = (List<PromosEntity>) request.getAttribute("promos");
                List<FormersEntity> formers = (List<FormersEntity>) request.getAttribute("formers");
                  if (promos != null) {

                  for (PromosEntity promo: promos) { %>

                <tr id="row-text-<%=promo.getIdPromo()%>" class="w-full">
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <div class="flex items-center">
                      <div class="flex-shrink-0 w-10 h-10">
                        <img class="w-full h-full rounded-full"
                             src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2.2&w=160&h=160&q=80"
                             alt="" />
                      </div>
                      <div class="ml-3">
                        <p class="text-gray-900 whitespace-no-wrap">
                          <%=promo.getPromoName()%>
                        </p>
                      </div>

                    </div>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap"> <%=promo.getDescription()%></p>

                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap">
                      <%=promo.getCampus()%>
                    </p>
                  </td>
                  <%
                    FormersEntity formerPromo = null;
                    if (promo.getFormerId() != null) {
                      for (FormersEntity former: formers) {
                          if (promo.getFormerId()==former.getIdFormer()){
                            formerPromo = former;
                          }
                        }
                    }%>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p id="display-<%=promo.getIdPromo()%>" class="text-gray-900 whitespace-no-wrap">
                      <%
                        if (formerPromo != null) {
                      %>
                      <%=formerPromo.getFirstName() + " "+ formerPromo.getLastName()%>
                      <%}else {
                      %>
                      <%="Not Assigned"%>
                      <%}%>

                    </p>
                    <div id="assign-<%=promo.getIdPromo()%>" class="hidden col-span-6 sm:col-span-3">
                      <form action="/admin/promo/assign" method="post">
                        <input type="hidden" name="id" value="<%=promo.getIdPromo()%>">
                        <label for="promoId" class="block text-sm font-medium text-gray-700">
                          <select name="formerId" id="promoId" autocomplete="family-name"
                                  class="mt-1 block w-full border border-gray-300 rounded-md shadow-sm py-2 px-3 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                            <%
                              for (FormersEntity former : formers) {
                                boolean isAssigned = false;
                                for (PromosEntity promo1: promos) {
                                  if (promo.getFormerId() == null || promo1.getFormerId() == former.getIdFormer()) {
                                    isAssigned = true;
                                  }
                                }
                                if (!isAssigned){
                            %>
                            <option value="<%=former.getIdFormer()%>"><%=former.getFirstName() + " "+ former.getLastName()%></option>
                            <%
                                }
                              }
                            %>
                          </select>
                        </label>
                        <button type="submit"
                                class="w-full inline-flex justify-center rounded-md border border-transparent shadow-sm px-4 py-2 bg-red-600 text-base font-medium text-white hover:bg-red-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-red-500 sm:ml-3 sm:w-auto sm:text-sm">
                          Assign
                        </button>
                      </form>
                    </div>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <p class="text-gray-900 whitespace-no-wrap">
                     <%--<% SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");%>
                      <%= DateFor.format(promo.getCreatedAt()) %>--%>
                       06/11/2022
                    </p>
                  </td>
                  <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                    <%--open edit promo form--%>
                      <button type="button" onclick="assignForm(<%=promo.getIdPromo()%>)"
                              class="w-5 mr-3  transform hover:text-secondary-green hover:scale-110"
                      >
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" stroke-width="1.8" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                          <title>Assign former to promo</title>
                          <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                          <path d="M22 9l-10 -4l-10 4l10 4l10 -4v6"></path>
                          <path d="M6 10.6v5.4a6 3 0 0 0 12 0v-5.4"></path>
                        </svg>
                      </button>
                    <button type="button" onclick="editFormOpen(<%=promo.getIdPromo()%>)"
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
                      <a href="/admin/promo/delete?idPromo=<%=promo.getIdPromo()%>">
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
                      <jsp:param name="target" value="promo"/>
                      <jsp:param name="id" value="<%=promo.getIdPromo()%>"/>
                      <jsp:param name="promoName" value="<%=promo.getPromoName()%>"/>
                      <jsp:param name="description" value="<%=promo.getDescription()%>"/>
                      <jsp:param name="campus" value="<%=promo.getCampus()%>"/>
                    </jsp:include>
                  </td>
                </tr>
                <%--update promo form--%>

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
