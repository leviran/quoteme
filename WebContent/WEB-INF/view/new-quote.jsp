<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html>
            <head>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

                <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
                <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
                <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/stylesheet.css">
            </head>
            <body>
                <div class="container">
                    <div class="row">
                        <h1>Aqui iran las nuevas quotes </h1>
                        <div class="col-md-8 offset-md-2">
                            <form:form action="quotesaved" modelAttribute="newQuoteToAdd">
                                Quote: <form:textarea path="quote"  />
                                category: <form:input path="category" />
                                author: <form:input path="author"  />
                                source: <form:input path="source"  />
                                title: <form:input path="title"  />
                                <input type="submit" value="Save new quote" />
                            </form:form>

                        </div>

                    </div>
                </div>
            </body>
        </html>