<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>TaskTrack</title>
</head>

<body>

<h2>Task List</h2>

<a href="/tasks/new">Add Task</a>

<table border="1">

<tr>
<th>Image</th>
<th>Title</th>
<th>Description</th>
<th>Due Date</th>
<th>Priority</th>
<th>Status</th>
<th>Actions</th>
</tr>

<c:forEach var="task" items="${taskList}">

<tr>

<td>
<img src="/tasks/image/${task.id}" width="50"/>
</td>

<td>${task.title}</td>
<td>${task.description}</td>
<td>${task.dueDate}</td>
<td>${task.priority}</td>
<td>${task.status}</td>

<td>

<a href="/tasks/toggle/${task.id}">Toggle</a>

<a href="/tasks/delete/${task.id}">Delete</a>

</td>

</tr>

</c:forEach>

</table>

</body>
</html>