
// Create some sample person
MERGE (p1:Person {name: "Richard", username: "richard"})
MERGE (p2:Person {name: "Steven", username: "steven"})
MERGE (p3:Person {name: "Lucy", username: "lucy"})

// Create profile pictures for.
MERGE (p1)-[:AVATAR]->(pic1:Picture {url : "url1", date : timestamp()})
MERGE (p2)-[:AVATAR]->(pic2:Picture {url : "url2", date : timestamp()})
MERGE (p3)-[:AVATAR]->(pic3:Picture {url : "url3", date : timestamp()})

// Add friendship to our friends.
MERGE (p1)-[:FRIEND]->(p2)
MERGE (p3)-[:FRIEND]->(p1)

// Some messages sent between our people.
MERGE (p1)-[:SEND]->(m1:Message { content: "Hello!", date: timestamp()})-[:SENT_TO]->(p2)
MERGE (p2)-[:SEND]->(m2:Message { content: "Hi!", date: timestamp()})-[:SENT_TO]->(p1)

MERGE (p1)-[:SEND]->(m3:Message { content: "Hello!", date: timestamp()})-[:SENT_TO]->(p3)
MERGE (p3)-[:SEND]->(m4:Message { content: "Hi!", date: timestamp()})-[:SENT_TO]->(p1)
MERGE (p3)-[:SEND]->(m6:Message { content: "How are you ?", date: timestamp()})-[:SENT_TO]->(p1)

RETURN *;
