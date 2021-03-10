<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
        <head>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css"> 
            <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
        </head>
        <body>
            <div class="container">
                <div class="row">
                    <div class="col-md-4">

                        <c:forEach var="category" items="${allCategories.allCategories}">
                            <div class="col-md-12">
                                <a href="${category.testLink}">
                                    ${category.categoryName}
                                </a>
                            </div>
                            <br />
                        </c:forEach>

                    </div>
                    <div class="col-md-8">
                        <h1>Bienvenido/a ${currentUser.username}</h1>

                        <c:forEach var="quote" items="${displayedQuotes}">

                            <div class="col-md-10 quote-main-holder">
                                <div class="row">
                                    <div class="col-md-6">
                                        ${quote.category}
                                    </div>
                                    <div class="col-md-6">
                                        editar y cerrar
                                    </div>
                                </div>
                                <div class="row">
                                <div class="col-md-12 quote-text-block">
                                     ${quote.quote}
                                    </div>
                                </div>
                                <div class="row">
                                <div class="col-md-12">${quote.source}</div>
                                <div class="col-md-12">${quote.author}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </body>
    </html>