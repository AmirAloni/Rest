Spring Boot application with a REST controller, which expose a Swagger API catalog.
Data is persisted on H2 DB using JPA.

The application exposes the following APIs:

1. List of the inventory items list
   GET /api/items

2. Read item details
   GET /api/items/{item-number}

3. Withdrawal quantity of a specific item from stock
   PUT /api/items/withdrawal/{item-number}/{amount}

4. Deposit quantity of a specific item to stock
   PUT /api/items/deposit/{item-number}/{amount}

5. Add item to stock
 POST /api/items/add/{name}/{amount}/{inventory-code}

6. Delete an item from stock
   DELETE /api/items/{item-number}

