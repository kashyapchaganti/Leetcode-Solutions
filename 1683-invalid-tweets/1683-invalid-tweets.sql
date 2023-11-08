# Write your MySQL query statement below
SELECT 
    tweet_id 
from 
    tweets 
where 
    char_length(content)>15