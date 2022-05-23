CREATE TABLE items (
  id UUID,
  name TEXT
);

INSERT INTO items (id, name) VALUES 
  (gen_random_uuid(), 'item1'), 
  (gen_random_uuid(), 'item2'), 
  (gen_random_uuid(), 'item3');
