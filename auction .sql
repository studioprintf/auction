-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017-04-10 14:35:03
-- 服务器版本： 5.7.17-0ubuntu0.16.04.2
-- PHP Version: 7.0.15-0ubuntu0.16.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `auction`
--

-- --------------------------------------------------------

--
-- 表的结构 `auction`
--
-- 创建时间： 2017-04-10 06:32:33
--

CREATE TABLE `auction` (
  `auction_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `price` double NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='竞拍表';

--
-- 表的关联 `auction`:
--   `user_id`
--       `user` -> `user_id`
--   `goods_id`
--       `goods` -> `goods_id`
--

-- --------------------------------------------------------

--
-- 表的结构 `balance_log`
--
-- 创建时间： 2017-04-10 06:32:33
--

CREATE TABLE `balance_log` (
  `balance_log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `operation_type` varchar(45) NOT NULL,
  `operation_note` varchar(45) NOT NULL,
  `amount` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作纪录表';

--
-- 表的关联 `balance_log`:
--   `user_id`
--       `user` -> `user_id`
--

-- --------------------------------------------------------

--
-- 表的结构 `goods`
--
-- 创建时间： 2017-04-10 06:32:33
--

CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL,
  `create_user` int(11) NOT NULL,
  `state` varchar(45) NOT NULL,
  `reserve_price` double NOT NULL,
  `limit_price` double NOT NULL,
  `create_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `final_time` datetime NOT NULL,
  `final_price` double DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

--
-- 表的关联 `goods`:
--   `create_user`
--       `user` -> `user_id`
--

-- --------------------------------------------------------

--
-- 表的结构 `goodsinfo`
--
-- 创建时间： 2017-04-10 06:33:31
--

CREATE TABLE `goodsinfo` (
  `goods_id` int(11) NOT NULL,
  `goods_title` varchar(45) NOT NULL,
  `goods_describe` text NOT NULL,
  `goods_image1` text NOT NULL,
  `goods_image2` text,
  `goods_image3` text,
  `goods_image4` text,
  `goods_image5` text,
  `goods_image6` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息表';

--
-- 表的关联 `goodsinfo`:
--   `goods_id`
--       `goods` -> `goods_id`
--

-- --------------------------------------------------------

--
-- 表的结构 `user`
--
-- 创建时间： 2017-04-10 06:32:33
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(256) NOT NULL,
  `user_type` int(11) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `register_time` datetime NOT NULL,
  `sign_time` datetime DEFAULT NULL,
  `sign_ip` varchar(45) DEFAULT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `frozen_amount` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- 表的关联 `user`:
--

-- --------------------------------------------------------

--
-- 表的结构 `user_order`
--
-- 创建时间： 2017-04-10 06:32:33
--

CREATE TABLE `user_order` (
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `state` varchar(45) NOT NULL,
  `create_time` datetime NOT NULL,
  `finish_time` datetime DEFAULT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

--
-- 表的关联 `user_order`:
--   `goods_id`
--       `goods` -> `goods_id`
--   `user_id`
--       `user` -> `user_id`
--

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auction`
--
ALTER TABLE `auction`
  ADD PRIMARY KEY (`auction_id`),
  ADD KEY `userid_idx` (`user_id`),
  ADD KEY `goodsid_idx` (`goods_id`);

--
-- Indexes for table `balance_log`
--
ALTER TABLE `balance_log`
  ADD PRIMARY KEY (`balance_log_id`),
  ADD KEY `fk_operation_log_user_idx` (`user_id`);

--
-- Indexes for table `goods`
--
ALTER TABLE `goods`
  ADD PRIMARY KEY (`goods_id`),
  ADD KEY `create_user_idx` (`create_user`);

--
-- Indexes for table `goodsinfo`
--
ALTER TABLE `goodsinfo`
  ADD PRIMARY KEY (`goods_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name_UNIQUE` (`user_name`);

--
-- Indexes for table `user_order`
--
ALTER TABLE `user_order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `goods_id` (`goods_id`),
  ADD KEY `user_id` (`user_id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `auction`
--
ALTER TABLE `auction`
  MODIFY `auction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- 使用表AUTO_INCREMENT `balance_log`
--
ALTER TABLE `balance_log`
  MODIFY `balance_log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- 使用表AUTO_INCREMENT `goods`
--
ALTER TABLE `goods`
  MODIFY `goods_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- 使用表AUTO_INCREMENT `user_order`
--
ALTER TABLE `user_order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000;
--
-- 限制导出的表
--

--
-- 限制表 `auction`
--
ALTER TABLE `auction`
  ADD CONSTRAINT `auction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `auction_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `balance_log`
--
ALTER TABLE `balance_log`
  ADD CONSTRAINT `fk_operation_log_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `goods`
--
ALTER TABLE `goods`
  ADD CONSTRAINT `create_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `goodsinfo`
--
ALTER TABLE `goodsinfo`
  ADD CONSTRAINT `goodsinfo_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 限制表 `user_order`
--
ALTER TABLE `user_order`
  ADD CONSTRAINT `goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
