<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <table class="table table-striped">
            <tr>
                <th>Qte</th>
                <th>Spectacle</th>
                <th>S�ance</th>
                <th>Cat�gorie</th>
                <th>Tarif Nom
                <th>Tarif</th>
                <th></th>
            </tr>
            <c:forEach var="orderLine" items="${orderLines}">
                <tr>
                    <td>${orderLine.quantiteBillets}</td>
                    <td>${orderLine.seance.spectacle.titre}</td>
                    <td><fmt:formatDate value="${orderLine.seance.date}" pattern="HH:mm EE dd MMMM yyyy" /></td>
                    <td>${orderLine.categorie.nom}</td>
                    <td>${orderLine.totalPriceATI}</td>
                    <c:url var="urlDelete" value="FrontController">
                        <c:param name="section" value="cart-operations" />
                        <c:param name="action" value="remove" />
                        <c:param name="categoryId" value="categorie.id" />
                        <c:param name="rateId" value="tarif.id" />
                    </c:url>
                    <td><a href='${urlDelete}'>X</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div class="col-md-7"></div>
        <div class="col-md-3">
            <label>Total: ${totalPrice} &euro;</label>
        </div>
        <div class="col-md-2">
            <button class="btn">Payer</button>
        </div>
    </div>
</div>

