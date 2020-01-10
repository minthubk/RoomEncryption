# RoomEncryption

i) Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

ii) Apps that handle non-trivial amounts of structured data can benefit greatly from persisting that data locally. The most common use case is to cache relevant pieces of data. That way, when the device cannot access the network, the user can still browse that content while they are offline. Any user-initiated content changes are then synced to the server after the device is back online.

There are 3 major components in Room:

Database: Contains the database holder and serves as the main access point for the underlying connection to your app's persisted, relational data.

The class that's annotated with @Database should satisfy the following conditions:

Be an abstract class that extends RoomDatabase.
Include the list of entities associated with the database within the annotation.
Contain an abstract method that has 0 arguments and returns the class that is annotated with @Dao.
At runtime, you can acquire an instance of Database by calling Room.databaseBuilder() or Room.inMemoryDatabaseBuilder().

Entity: Represents a table within the database.

DAO: Contains the methods used for accessing the database.
