INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("cocacola","00001","bebida",2.0,"2022-06-16",6);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("patatas","00002","comida",3.0,"2022-06-16",4);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("helado","00003","comida",2.0,"2022-06-16",3);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("arroz","00004","comida",2.0,"2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("comida de perro","00005","mascota",5.0,"2022-06-16",1);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("lejía","00006","limpieza",5.0,"2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("gazpacho","00007","comida",3.0,"2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("pastel","00008","comida",7.0,"2022-06-16",1);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("carne","00009","comida",9.0,"2022-06-16",4);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Fecha_Registro,Cantidad) VALUES ("balleta","00010","limbieza",3.0,"2022-06-16",4);


/* Al no disponer de la base de datos que tenía que haberme pasado Rocío tras haber subido ella las imágenes a la carpeta uploads,
 * he tenido que abrir el único archivo que me ha pasado, la tabla productos, he corregido el nombre y he puesto producto en su lugar, tanto en el nombre del archivo como en los valores de la tabla, puesto que no se ceñía a lo estipulado en las especificaciones.
 * He cogido las líneas de querys que tenía el archivo y las he modificado para poder referenciar las imágenes, que se encontraban en la carpeta uploads, con los productos con los que se correspondían.
 * 
 * */


/*INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("cocacola","00001","bebida",2.0,"0d6d5132-10ee-4f16-a85c-773e32abdc5b_cocaCola.webp","2022-06-16",6);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("patatas","00002","comida",3.0,"f8a4f736-05d6-416e-8797-ae1e1aa14b99_patatas.jpg","2022-06-16",4);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("helado","00003","comida",2.0,"b35c4453-0b12-4dfb-9103-a4418202e23d_helados.jpg","2022-06-16",3);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("arroz","00004","comida",2.0,"5d406e35-8c03-4395-9a19-31dac4982321_arroz.jpg","2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("comida de perro","00005","mascota",5.0,"bdf2cab2-64b2-48de-897b-d8dec3c7d114_comidaPerros.webp","2022-06-16",1);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("lejía","00006","limpieza",5.0,"7476c5bd-a887-43c2-8806-8c6924e1ee7d_lejia.jpg","2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("gazpacho","00007","comida",3.0,"6c2eb66a-3188-4cc2-a7db-1636f8817abe_gazpacho.jpg","2022-06-16",2);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("pastel","00008","comida",7.0,"463b83a2-008e-4c8c-a380-1edd61915fc8_pastel.jpg","2022-06-16",1);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("carne","00009","comida",9.0,"f857de47-4c23-4cee-affc-ae249945029a_carne.jpg","2022-06-16",4);
INSERT INTO producto(Nombre,Cod_Producto,Tipo,Precio,Imagen,Fecha_Registro,Cantidad) VALUES ("balleta","000010","limpieza",3.0,"89fad0c3-b648-45c3-a3d5-9e2c174f733c_bayeta.jpg","2022-06-16",4);*/


INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Juan","Oller","54446442D","jp@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Maria","ladelbarrio","54445442D","mla@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Pepito","Ruiz","54444442D","jp3@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Carlos","Perez","54436442D","jp2@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Lola","Pirez","54442442D","jp1@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Marcelo","Rainiero","54441442D","jp43@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Leomar","Leon","54440442D","jp23@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Cristino","Rolando","54476442D","jp24@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Allegra","kholl","54448442D","jp14@gmail.com",6321122,"2022-06-16");
INSERT INTO cliente(Nombre,Apellido,Nif,Email,Telefono,create_at) VALUES ("Ragnar","Loubrok","54449442D","jp424@gmail.com",6321122,"2022-06-16");

INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Juan","Oller","jsdp@gmail.com",6321122,"c/Brasil num: 9 cp:64897","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Maria","ladelbarrio","mla@gmail.com",6321122,"c/Lora num: 56 cp:65497","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Pepito","Ruiz","jfgjp@gmail.com",6321122,"c/Coria num: 65 cp:65647","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Carlos","Perez","jjlñp@gmail.com",6321122,"c/ num: 94 cp:54989","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Lola","Pirez","erjp@gmail.com",6321122,"c/num:cp:35648","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Marcelo","Rainiero","jjkñp@gmail.com",6321122,"c/Mendez num: 84 cp:65984","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Leomar","Leon","jsep@gmail.com",6321122,"c/Lorca num: 34 cp:65899","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Cristino","Rolando","fvbnjp@gmail.com",6321122,"c/Velazquez num: 65 cp:65498","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Allegra","kholl","jfghp@gmail.com",6321122,"c/Circo num: 35 cp:68796","2022-06-16");
INSERT INTO proveedor(Nombre,Nif,Email,Telefono,Direccion,create_at) VALUES ("Ragnar","Loubrok","jlkñp@gmail.com",6321122,"c/Feria num: 40 cp:65943","2022-06-16");*/

INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (1,1,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (2,2,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (3,3,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (4,4,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (5,5,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (6,6,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (7,7,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (8,8,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (9,9,5,"2022-06-16");
INSERT INTO venta(id_producto,id_cliente,total,fecha_venta) VALUES (10,10,5,"2022-06-16");








