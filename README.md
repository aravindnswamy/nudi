# nudi - a devabhasha for computer

A simple to use language for command line file data processing.

## Requirements
Java 1.8 or later

## Installation
Run ./install.sh - requires sudo permission
Make sure /usr/local/bin/ is included in your PATH.

## Usage
<pre>
<code>
➜  ~ cat ~/Desktop/sample
Hello World!
Over 3.8 billion people use the internet today, which is 40% of the world's population.
More than 570 new websites are created every minute.
There are over 3.5 billion searches per day on Google.
192.168.1.1
Phone:+(91) 9999999999
➜  ~ nudi rows ~/Desktop/sample
4
➜  ~ nudi columns ~/Desktop/sample
1
➜  ~ nudi splitBy are ~/Desktop/sample
Hello World!
Over 3.8 billion people use the internet today, which is 40% of the world's population.
More than 570 new websites are created every minute.
There are over 3.5 billion searches per day on Google.
192.168.1.1
Phone:+(91) 9999999999

➜  ~ nudi splitBy o ~/Desktop/sample
Hi, h w are y u?
Hell  W rld!
Over 3.8 billi n pe ple use the internet t day, which is 40%  f the w rld's p pulati n.
M re than 570 new websites are created every minute.
There are  ver 3.5 billi n searches per day  n G  gle.
192.168.1.1
Ph ne:+(91) 9999999999

➜  ~ nudi replace o ooo ~/Desktop/sample
Whooo are yooou tooo wave yooour finger?
Yooou must have been ooout yooour head
Eye hooole deep in muddy waters
Yooou practically raised the dead

➜  ~ nudi splitBy ooo replace o ooo ~/Desktop/sample
Hi, h w are y u?
Hell  W rld!
Over 3.8 billi n pe ple use the internet t day, which is 40%  f the w rld's p pulati n.
M re than 570 new websites are created every minute.
There are  ver 3.5 billi n searches per day  n G  gle.
192.168.1.1
Ph ne:+(91) 9999999999

➜  ~ nudi find find Hello ~/Desktop/sample
Hello World!

</code>
</pre>