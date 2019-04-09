# springBoot-Mysql
springBoot2.X 读写分离，多数据源，一主多从，多主多从

## 为什么要需要读写分离？
大型网站为了解决大量的并发访问，除了在网站实现分布式负载均衡远远不够，到了数据业务层、数据访问层，如果还是传统的数据结构，或者只是单单靠一台服务器来处理如此多的数据库连接操作，数据库必然会崩溃，特别是数据丢失的话，后果更是不堪设想。这时候，我们会考虑如何减少数据库的连接。

利用主从数据库来实现读写分离，从而分担主数据库的压力。在多个服务器上部署mysql，将其中一台认为主数据库，而其他为从数据库，实现主从同步。其中主数据库负责主动写的操作，而从数据库则只负责主动读的操作（slave从数据库仍然会被动的进行写操作，为了保持数据一致性），这样就可以很大程度上的避免数据丢失的问题，同时也可减少数据库的连接，减轻主数据库的负载。

## TODO LIST
* [x] [读写分离](#Mysql)
* [x] [多数据源](一主多从，多主多从，多数据库（mysql,oracle）)

## 联系作者
- [906053856@qq.com]
