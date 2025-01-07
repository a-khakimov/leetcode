-- 1407. Top Travellers
-- https://leetcode.com/problems/top-travellers

select users.name, sum(coalesce(distance, 0)) as travelled_distance
from users left join rides on users.id = rides.user_id
group by users.id, users.name
order by travelled_distance desc, users.name asc;
