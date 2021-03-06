<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.min.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Home</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div class="container">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-md-5">
                    <form action="FrontController" method="POST">
                        <div class="row">
                            <div class='col-md-5'>
                                <label>Civilité</label>
                            </div>
                            <div class='col-md-7'>
                                <label for="radioM" style="width: 80px"><input type="radio" name="civilite" value="M" id="radioM" />Monsieur</label>
                                <label for="radioMme" style="width: 80px"><input type="radio" name="civilite" value="MME" id="radioMme" checked="checked" />Madame</label>
                            </div>
                            <br/><br/>
                            <div class='col-md-5'><label>Nom</label></div><div class='col-md-7'><input type="text" name="nom" placeholder="Long" pattern="[A-Za-z 1-9-_¨^èé'ùàç]{2,150}" required="required" /></div>
                            <br/><br/>
                            <div class='col-md-5'><label>Prénom</label></div><div class='col-md-7'><input type="text" name="prenom" placeholder="Phi" pattern="[A-Za-z 1-9-_¨^èé'ùàçz]{2,150}" /></div>
                            <br/><br/>
                            <div class='col-md-5'><label>Email</label></div><div class='col-md-7'><input type="email" name="email" value="" placeholder="Enter email" required="required"/></div>
                            <div class='col-md-5'></div><div class='col-md-7'>
                                <p class="error" style="color: red">
                                    ${errorMessage}
                                </p></div>
                                <br/><br/><br>
                                
                            <div class='col-md-5'><label>Mot de passe</label></div><div class='col-md-7'><input type="password" name="mdp" value="" pattern=".{4,30}" required="required" /></div>
                            <br/><br/>
                            <div class='col-md-5'><label>Mot de passe</label></div><div class='col-md-7'><input type="password" name="mdp2" value="" pattern=".{4,30}" required="required" /></div>
                            <br/><br/>
                            <div class='col-md-5'><label>Date de naissance</label></div><div class='col-md-7'><input type="date" name="dateNaissance" placeholder="JJ/MM/AAAA" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" /></div><br/><br/>
                            <input type="hidden" name="section" value="client">
                            <input type="hidden" name="action" value="signup">
                            <div class='col-md-5'></div><div class='col-md-7'><input type="submit" value="S'inscrire" /></div>
                    </form>
                    <div class='col-md-5'></div>


                </div>
            </div>
        </div>
    </div>
</body>
</html>
