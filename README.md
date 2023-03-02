# GraphQL-Server-Springboot

1. open graphiql by using `http://127.0.0.1:8080/graphiql`  
2. sample graphql query used for current project:
```
query{
  authorById(id: 1){
    id
    name
  }
  authors{
    id
    name
    bookList{
      title
    }
  }
}
```
3. Mutation example:
```
mutation{
  addBook(book: {title: "Spring Cloud in action", publisher: "some co", authorId: 2}){
    id
  }
}
```
4. Author controller uses pojos which are connected by jpa relations.  
5. getPaper uses queryDsl.  
6. Person Controller uses schema mapping to get fields.  
7. Error Handler throws custom error messages for our self thrown exceptions.  