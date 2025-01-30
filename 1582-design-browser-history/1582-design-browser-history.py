class Browser:
    def __init__(self, url=None, prev=None, next=None):
        self.url = url
        self.prev = prev
        self.next = next


class BrowserHistory(object):

    def __init__(self, homepage):
        """
        :type homepage: str
        """
        new_browser = Browser(url=homepage)
        self.head = new_browser
        self.current = new_browser
        self.tail = new_browser
        

    def visit(self, url):
        """
        :type url: str
        :rtype: None
        """
        new_browser = Browser(url=url, prev=self.current)
        self.current.next = new_browser
        self.current = self.current.next
        self.tail = self.current
        
        

    def back(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while self.current.prev:
            if steps==0:
                break
            steps -= 1
            self.current = self.current.prev
        return self.current.url

        

    def forward(self, steps):
        """
        :type steps: int
        :rtype: str
        """
        while self.current.next:
            if steps==0:
                break
            steps -= 1
            self.current = self.current.next
        return self.current.url