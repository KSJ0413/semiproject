use webtest;
drop table cart;
CREATE TABLE IF NOT EXISTS `webtest`.`cart` (
  `cartno` INT NOT NULL AUTO_INCREMENT COMMENT '장바구니 번호',
  `count` INT NOT NULL,
  `contentsno` INT NOT NULL,
  `id` VARCHAR(10) NOT NULL,
  `size` VARCHAR(3) NULL,
  PRIMARY KEY (`cartno`),
  CONSTRAINT `fk_cart_contents1`
    FOREIGN KEY (`contentsno`)
    REFERENCES `webtest`.`contents` (`contentsno`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `fk_cart_member1`
    FOREIGN KEY (`id`)
    REFERENCES `webtest`.`member` (`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

	select
		c.contentsno, c.pname, c.price, c.filename,
		t.cartno, t.size, t.count, t.id
		from contents c inner join cart t
		on c.contentsno = t. contentsno
		where id = 'asd'








select * from cart;



delete from cart;