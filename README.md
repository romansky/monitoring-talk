Monitoring For Developers - Workshop (StatsCraft 2015 30/7/15)
===

Roman Landenband 2015 (c)

Pre-requisits
-----

 1. have Java 8 installed on your host machine
 2. have Docker installed on your host mchine


Static Analysis
---

How to make your environment ready for the workshop

 1. clone this repo `git clone git@github.com:romansky/monitoring-talk.git`
 2.

JIT
---

How to follow the workshop with your machine

Setting up the environemnt
-----

 1. Clone workshop repo `#> git clone git@github.com:romansky/monitoring-talk.git`
 2. from within the repo directory, inside the "server" directory issue the following commands:

"""
#> docker build -t monitoringtalk/monitoringapp .
#> docker run -p 8000:8000 monitoringtalk/monitoringapp
"""


