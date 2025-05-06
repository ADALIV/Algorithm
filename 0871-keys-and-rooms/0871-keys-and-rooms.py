class Solution(object):
    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        def visit(room, visited):
            visited.add(room)
            for key in rooms[room]:
                if key not in visited:
                    visit(key, visited)
        visited=set()
        visit(0, visited)
        return  len(visited)==len(rooms)