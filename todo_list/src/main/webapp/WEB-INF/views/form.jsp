<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add Task</title>
</head>

<body>

<h2>Add Task</h2>

<form:form method="post"
action="/tasks/save"
modelAttribute="task"
enctype="multipart/form-data">

Title:

<form:input path="title"/>

<form:errors path="title"/>

<br><br>

Description:

<form:textarea path="description"/>

<form:errors path="description"/>

<br><br>

Due Date:

<form:input path="dueDate" type="date"/>

<form:errors path="dueDate"/>

<br><br>

Priority:

<form:select path="priority">

<form:option value="">Select</form:option>

<form:option value="LOW">LOW</form:option>

<form:option value="MEDIUM">MEDIUM</form:option>

<form:option value="HIGH">HIGH</form:option>

</form:select>

<form:errors path="priority"/>

<br><br>

Image:

<input type="file" name="imageFile"/>

<br><br>

<button type="submit">Save Task</button>

<a href="/tasks">Cancel</a>

</form:form>

</body>

</html>