 var screenClass = function()
    {
        /// 解锁
        this.unlock = function()
        {
            var divLock = document.getElementById("divLock");
            if(divLock == null) return;
            document.body.removeChild(divLock);
        };
        
        /// 锁屏
        this.lock = function(imgPath)
        {
            var sWidth,sHeight;
            sWidth  = document.body.clientWidth;
            sHeight = window.screen.availHeight;
            var bgObj=document.createElement("div");
            bgObj.setAttribute("id","divLock");
            bgObj.style.position="absolute";
            bgObj.style.top="0";
            bgObj.style.left="0";
            bgObj.style.width=sWidth + "px";
            bgObj.style.height=sHeight + "px";
            var div=document.createElement("div");
            div.style.position="absolute";
            div.style.top="0";
            div.style.background="#cccccc";
            div.style.opacity="0.3";
            div.style.filter = "progid:DXImageTransform.Microsoft.Alpha(Opacity=30)"
            div.style.left="0";
            div.style.width=sWidth + "px";
            div.style.height=sHeight + "px";
            div.style.zIndex = "100";
            bgObj.appendChild(div);
            
            var img=document.createElement("img");
            img.style.position="absolute";
            img.src=imgPath;
            img.style.top="200px";
            img.style.left=(sWidth/2-20)+"px";
            bgObj.appendChild(img);
            
            document.body.appendChild(bgObj);
            // 解锁
            bgObj.onclick = function()
            {
                 //new screenClass().unlock();
            }
        };
    }