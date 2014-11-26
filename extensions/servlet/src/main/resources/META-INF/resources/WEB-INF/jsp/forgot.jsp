<%--
  ~ Copyright 2014 Stormpath, Inc.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~     http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License.
  --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://stormpath.com/jsp/tags/templates" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:page>
    <jsp:attribute name="title">Forgot your password?</jsp:attribute>
    <jsp:attribute name="description">Forgot your password?</jsp:attribute>
    <jsp:attribute name="bodyCssClass">login</jsp:attribute>
    <jsp:body>
        <div class="container custom-container">

            <div class="va-wrapper">

                <div class="view login-view container">

                    <div class="box row">

                        <div class="email-password-area col-xs-12 large col-sm-12">

                            <div class="header">
                                <span>Forgot your password?</span>

                                <p>Enter your email address below to reset your password. You will
                                    be sent an email which you will need to open to continue. You may
                                    need to check your spam folder.</p>
                            </div>

                            <c:if test="${!empty errors}">
                                <div class="alert alert-dismissable alert-danger bad-login">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    <c:forEach items="${errors}" var="error">
                                        <p>${error}</p>
                                    </c:forEach>
                                </div>
                            </c:if>

                            <form method="post" role="form" class="login-form form-horizontal">
                                <c:if test="${!empty form.next}">
                                    <input name="next" type="hidden" value="${form.next}">
                                </c:if>
                                <input name="csrfToken" type="hidden" value="${form.csrfToken}">

                                <c:forEach items="${form.fields}" var="field">
                                    <div form-group="true" class="form-group group-${field.name}">
                                        <label class="col-sm-4">${field.label}</label>
                                        <div class="col-sm-8">
                                            <input name="${field.name}" value="${field.value}" type="${field.type}"
                                                   placeholder="${field.placeholder}"
                                                   <c:if test="${field.autofocus}">autofocus="autofocus" </c:if>
                                                   <c:if test="${field.required}">required="required" </c:if>
                                                   class="form-control">
                                        </div>
                                    </div>
                                </c:forEach>

                                <div>
                                    <button type="submit" class="login btn btn-login btn-sp-green">Send Email</button>
                                </div>
                            </form>

                        </div>

                    </div>

                    <a href="${pageContext.request.contextPath}${requestScope['stormpath.web.login.url']}" class="to-login">Back to Log In</a>

                </div>

            </div>

        </div>

    </jsp:body>

</t:page>