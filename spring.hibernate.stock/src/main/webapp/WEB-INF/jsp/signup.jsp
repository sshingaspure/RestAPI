<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Sign Up FOrm</title>
</head>

<body>
	<h2>Please fill the information</h2>
	<h2>${message}</h2>
	<h2 id="errorMsg"></h2>
	<form:form method="POST" action="register"
		id="registrationForm">
		<table>
			<tr>
				<td><form:label path="username">Enter User Name: </form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">Enter First Name: </form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Enter Last Name: </form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter Password: </form:label></td>
				<td><form:input path="password" type="password" id="pass1" /></td>
			</tr>
			<tr>
				<td>Re-enter Password:</td>
				<td><input type="password" id="pass2" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Submit"
					onclick="checkPassword()" /></td>
			</tr>
		</table>
	</form:form>

	<script type="text/javascript">
		function checkPassword() {
			var pass1 = document.getElementById("pass1").value;
			var pass2 = document.getElementById("pass2").value;

			if (pass1===pass2) {
				document.getElementById("registrationForm").submit();
			} else {
				document.getElementById("errorMsg").innerHTML = "Password did not match!!";
				console.log(pass1+" : "+pass2);
			}

		}
	</script>
</body>

</html>