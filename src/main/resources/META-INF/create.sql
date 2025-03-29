
INSERT INTO students (name, email, phone) VALUES ('Student 1', 'Email 1', 'Phone 1');
INSERT INTO students (name, email, phone) VALUES ('Student 2', 'Email 2', 'Phone 2');
INSERT INTO students (name, email, phone) VALUES ('Student 3', 'Email 3', 'Phone 3');


-- @OneToMany and @ManyToOne
INSERT INTO categories (id, name) VALUES (1001, 'category 1');
INSERT INTO categories (id, name) VALUES (1002, 'category 2');
INSERT INTO categories (id, name) VALUES (1003, 'category 3');

INSERT INTO products (id, name, category_id) VALUES (101, 'product 1', 1002);
INSERT INTO products (id, name, category_id) VALUES (102, 'product 2', 1003);
INSERT INTO products (id, name, category_id) VALUES (103, 'product 3', 1001);
INSERT INTO products (id, name, category_id) VALUES (104, 'product 4', 1001);
