// Create index on person username
CREATE CONSTRAINT ON (person:Person) ASSERT person.username IS UNIQUE