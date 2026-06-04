DELETE FROM order_event where product in ('coco','cacao','bred');

INSERT INTO order_event (product , quantity , email)
VALUES ('coco', 250, 'rafaelewane@yahoo.fr'),
       ('cacao', 400, 'abigailewane@gmail.com'),
       ('bred', 1000, 'perlaewane@yahoo.fr');
