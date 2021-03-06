<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:url value="/css/style.css" var="url01" />
        <link href="${url01}" rel="stylesheet" type="text/css"/>
        <c:url value="/bootstrap/css/bootstrap.min.css" var="urlBootstrap" />
        <link href="${urlBootstrap}" rel="stylesheet" type="text/css"/>
        <title>Billet Ti - Client</title>
    </head>
    <body>
        <c:url value="FrontController?section=navigation" var="url02" />
        <c:import url="${url02}" />
        <c:url value="FrontController?section=search" var="url03" />
        <c:import url="${url03}" />
        <hr />
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <form action="FrontController" method="POST">
                    <div class="col-md-4">
                        <input type="hidden" name="section" value="client" />
                        <input type="hidden" name="action" value="manage" />
                        <label>Civilité:&nbsp;</label> ${client.civilite}<br>
                        <label>Nom:&nbsp;</label><input type="text" name="nom" value="${client.nom}" /><br>
                        <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${client.prenom}" /><br>
                        <label>Mail:&nbsp;</label><input type="text" name="mail" value="${client.email}" /><br>
                        <label>Mot de passe:&nbsp;</label><input type="password" name="motDePasse" /><br>
                        <label>Date de Naissance:&nbsp;</label><input type="date" name="dateNaissance" value="<fmt:formatDate value="${client.dateNaissance}" pattern="yyyy-MM-dd" />" placeholder="JJ/MM/AAAA" pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d" title="JJ/MM/AAAA"/><br>

                    </div>
                    <div class="col-md-2">
                        <input type="submit" value="Modification" name="doIt" />
                    </div>
                </form>



            </div>
            <div class="col-md-6">
                <p class="alert-info">
                    ${message}
                </p>
            </div>        
        </div>

                
                <div class="row">
                  <%--ADRESSE DE FACTURATION --%>        


        <div class="col-md-6"> 
            <form action="FrontController" method="POST">
                <input type="hidden" name="action" value="manage" />
                <h1>Adresse Facturation:&nbsp;</h1>

                <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${client.coordonneesFacturation.prenom}"/><br>
                <label>Nom:&nbsp;</label><input type="text" name="nom" value="${client.coordonneesFacturation.nom}"/><br>
                <label>Nom de l'Entreprise:&nbsp;</label><input type="text" name="entreprise" value="${client.coordonneesFacturation.entreprise}"/><br>
                <label>N°:&nbsp;</label><input type="text" name="numeroVoie" value="${client.coordonneesFacturation.numeroVoie}"/><br>
                <label>Type de voie:&nbsp;</label><input type="text" name="typeVoie" value="${client.coordonneesFacturation.typeVoie}"/><br>
                <label>Nom de la voie:&nbsp;</label><input type="text" name="nomVoie" value="${client.coordonneesFacturation.nomVoie}"/><br>
                <label>Telephone:&nbsp;</label><input type="text" name="telephone" value="${client.coordonneesFacturation.telephone}"/><br>
                <label>Telephone Mobile:&nbsp;</label><input type="text" name="telephoneMobile" value="${client.coordonneesFacturation.telephoneMobile}"/><br>
            </form> 
        </div>
            <label>Adresse de Facturation = Livraison</label><input type="radio" name="" value="manage" />

            <div class="col-md-6">
               

            <%--ADRESSE DE LIVRAISON --%>        

            <form action="FrontController" method="POST">
                <input type="hidden" name="action" value="manage" />
                <h1>Adresse Livraison:&nbsp;</h1>


                <select name="adLivraison">
                    <c:forEach var="i" items="${client.listeCoordonneesLivraison}">
                        <option>
                            ${i.nom}
                            ${i.prenom}
                            ${i.entreprise}
                            ${i.numeroVoie}
                            ${i.nomVoie}
                            ${i.telephone}
                            ${i.telephoneMobile}
                        </option>
                    </c:forEach>
                </select>

                <label>Prenom:&nbsp;</label><input type="text" name="prenom" value="${i.prenom}"/><br>
                <label>Nom:&nbsp;</label><input type="text" name="nom" value="${i.nom}"/><br>
                <label>Nom de l'Entreprise:&nbsp;</label><input type="text" name="entreprise" value="${i.entreprise}"/><br>
                <label>N°:&nbsp;</label><input type="text" name="numeroVoie" value="${i.numeroVoie}"/><br>
                <label>Type de voie:&nbsp;</label><input type="text" name="typeVoie" value="${i.typeVoie}"/><br>
                <label>Nom de la voie:&nbsp;</label><input type="text" name="nomVoie" value="${i.nomVoie}"/><br>
                <label>Telephone:&nbsp;</label><input type="text" name="telephone" value="${i.telephone}"/><br>
                <label>Telephone Mobile:&nbsp;</label><input type="text" name="telephoneMobile" value="${i.telephoneMobile}"/><br>

            </form> 
                
                
            </div>  
                </div>
        

            
            

    </body>
</html>
