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