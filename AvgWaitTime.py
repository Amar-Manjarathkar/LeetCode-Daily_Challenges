class Solution:
    def averageWaitingTime(self, customers: List[List[int]]) -> float:
        next_idle_time = 0  # Time when the chef will be next idle
        net_wait_time = 0  # Total waiting time for all customers

        for customer in customers:
            next_idle_time = max(customer[0], next_idle_time) + customer[1]
            net_wait_time += next_idle_time - customer[0]

        return net_wait_time / len(customers)
