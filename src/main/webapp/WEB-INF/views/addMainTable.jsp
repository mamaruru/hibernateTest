<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	
        <form:form method="POST" action="addMainTable" modelAttribute="mainTable">
             <table>
                <tr>
                    <td><form:label path="str1">Str1</form:label></td>
                    <td><form:input path="str1"/></td>
                </tr>
                <tr>
                    <td><form:label path="str2">Str2</form:label></td>
                    <td><form:input path="str2"/></td>
                </tr>
                <tr>
                    <td><form:label path="num1">Num1</form:label></td>
                    <td><form:input path="num1"/></td>
                </tr>
                <tr>
                    <td><form:label path="num2">Num2</form:label></td>
                    <td><form:input path="num2"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>