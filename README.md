# BiGramSpamFilter_2013
This application implements a Bi-Gram Spam Filter with HashMap in Java.</br>
The probability in a document with k n-grams (and hence k+n-1 words) is defined as the product of the individual probabilities, normalized by taking its k-th root as following: </br>

<a href="https://www.codecogs.com/eqnedit.php?latex=\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i&plus;1}\cdots&space;w_{i&plus;1})}" target="_blank"><img src="https://latex.codecogs.com/gif.latex?\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i&plus;1}\cdots&space;w_{i&plus;1})}" title="\sqrt[k]{\prod_{i=0}^{k-1}P(w_{i+1}\cdots w_{i+1})}" /></a>

,where
<a href="https://www.codecogs.com/eqnedit.php?latex=P(w_{i&plus;1}\cdots&space;w_{i&plus;1})" target="_blank"><img src="https://latex.codecogs.com/gif.latex?P(w_{i&plus;1}\cdots&space;w_{i&plus;1})" title="P(w_{i+1}\cdots w_{i+1})" /></a>
means number of occurrences of the n-gram.
