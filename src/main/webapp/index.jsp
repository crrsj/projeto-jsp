<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<html lang = "en">
<head>
<meta charset="UTF-8">
<title>Curso JSP</title>
</head>
<style>
 body{
 
 height: 10em;
    position: relative ;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    margin-right: -50%;
    transform: translate(-50%, -50%);
 }
 
</style>
<body>
   <h1>CURSO JAVA-JSP</h1>
  
   
   <form action="ServletLogin" method="post" class="row g-3 needs-validation" novalidate> 
     <input type="hidden" value="<%= request.getParameter("url")%>" name="url">       
   <div class="mb-3">  
     <label class="form-label">Login</label>
     <input class="form-control" name=login type="text" required="required">
     <div class="valid-feedback">
      Login Preenchido!
    </div>
      <div class="invalid-feedback">
      Preencha o  login corretamante
    </div>
     
   </div> 
      <div class="mb-3">
     <label class="form-label">Senha</label>
     <input class="form-control" name=senha type="password" required="required">          
     <div class="valid-feedback">
      Senha preenchida!
    </div>
     <div class="invalid-feedback">
      Preencha a senha corretamente!
    </div>
     
  </div> 
  <div class="col-12">
    <input class="btn btn-primary" type="submit" value="Entrar">       
  </div>  
        
</form>
   <h4>${msg}</h4> 
   <script type="text/javascript">
   (() => {
	   'use strict'

	   // Fetch all the forms we want to apply custom Bootstrap validation styles to
	   const forms = document.querySelectorAll('.needs-validation')

	   // Loop over them and prevent submission
	   Array.from(forms).forEach(form => {
	     form.addEventListener('submit', event => {
	       if (!form.checkValidity()) {
	         event.preventDefault()
	         event.stopPropagation()
	       }

	       form.classList.add('was-validated')
	     }, false)
	   })
	 })()
   
   </script>
</body>
</html>