"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[548],{88548:(Ot,v,r)=>{r.r(v),r.d(v,{AccessModule:()=>jt});var d=r(60177),A=r(18498),T=r(10467),l=r(9159),u=r(89417),p=r(34006),G=/\s/;var j=/^\s+/;const O=function w(e){return e&&e.slice(0,function N(e){for(var i=e.length;i--&&G.test(e.charAt(i)););return i}(e)+1).replace(j,"")};var y=r(30554),S=r(74077),Y=/^[-+]0x[0-9a-f]+$/i,k=/^0b[01]+$/i,M=/^0o[0-7]+$/i,L=parseInt;var R=1/0;const H=function U(e){return e?(e=function X(e){if("number"==typeof e)return e;if((0,S.A)(e))return NaN;if((0,y.A)(e)){var i="function"==typeof e.valueOf?e.valueOf():e;e=(0,y.A)(i)?i+"":i}if("string"!=typeof e)return 0===e?e:+e;e=O(e);var o=k.test(e);return o||M.test(e)?L(e.slice(2),o?2:8):Y.test(e)?NaN:+e}(e))===R||e===-R?17976931348623157e292*(e<0?-1:1):e==e?e:0:0===e?e:0},K=function Z(e,i){var o;if("function"!=typeof i)throw new TypeError("Expected a function");return e=function B(e){var i=H(e),o=i%1;return i==i?o?i-o:i:0}(e),function(){return--e>0&&(o=i.apply(this,arguments)),e<=1&&(i=void 0),o}};var t=r(17705),_=r(97405),f=r(52920),x=r(99213),h=r(88834),Q=r(30450),g=r(85691),F=r(14823),I=r(71997);function q(e,i){if(1&e){const o=t.RV6();t.j41(0,"div",9)(1,"mat-slide-toggle",10),t.bIt("change",function(c){const s=t.eBV(o).$implicit,m=t.XpG();return t.Njj(m.toggleActionChange(c.checked,s))}),t.EFF(2),t.k0s()()}if(2&e){const o=i.$implicit,n=t.XpG();t.R7$(1),t.Y8G("checked",n.isActionChecked(o)),t.R7$(1),t.JRh(o.action)}}let tt=(()=>{class e{constructor(o,n,c){this.dialogRef=o,this.data=n,this.apiClient=c,this.successConfigure=a=>{this.dialogRef.close(a)},this.before=K}ngOnInit(){}toggleActionChange(o,n){let c=!0;for(let a=0;a<this.data.privilegeList.length;a++)if(this.data.privilegeList[a].idAuthAction===n.id){this.data.privilegeList[a].enable=o,c=!1;break}c&&this.data.privilegeList.push({id:null,idAuthAction:n.id,idAuthRoleResource:null,enable:o})}isActionChecked(o){return!!this.data.privilegeList.find(n=>n.idAuthAction===o.id&&n.enable)}submitData(){0!==this.data.privilegeList.length?this.apiClient.postRequest(`/api/role/configure-privileges?roleId=${this.data.roleId}&resourceId=${this.data.resourceId}`,this.data.privilegeList).subscribe({next:this.successConfigure,error:console.error}):this.dialogRef.close(!1)}static{this.\u0275fac=function(n){return new(n||e)(t.rXU(p.CP),t.rXU(p.Vh),t.rXU(_.f))}}static{this.\u0275cmp=t.VBU({type:e,selectors:[["mc4-privileges"]],decls:17,vars:1,consts:[[3,"ngSubmit"],["fxLayout","row wrap","fxLayoutAlign","space-between center"],["fxFlex","90"],[1,"text-primary"],["fxFlex","10"],["mat-icon-button","","color","warn","matTooltip","Cancelar","type","button",3,"click"],["fxFlex","50","class","privilege-content",4,"ngFor","ngForOf"],["align","end",1,"mb10"],["mat-raised-button","","color","primary","type","submit"],["fxFlex","50",1,"privilege-content"],[3,"checked","change"]],template:function(n,c){1&n&&(t.j41(0,"form",0),t.bIt("ngSubmit",function(){return c.submitData()}),t.j41(1,"fury-card-header")(2,"div",1)(3,"div",2)(4,"h3",3),t.EFF(5,"Configurar accesos"),t.k0s()(),t.j41(6,"div",4)(7,"button",5),t.bIt("click",function(){return c.dialogRef.close()}),t.j41(8,"mat-icon"),t.EFF(9,"close"),t.k0s()()()()(),t.nrm(10,"mat-divider"),t.j41(11,"fury-card-content")(12,"div",1),t.DNE(13,q,3,2,"div",6),t.k0s()(),t.j41(14,"fury-card-actions",7)(15,"button",8),t.EFF(16,"Guardar"),t.k0s()()()),2&n&&(t.R7$(13),t.Y8G("ngForOf",c.data.actionList))},dependencies:[d.Sq,f.DJ,f.sA,f.UI,x.An,h.$z,h.iY,Q.sG,g.mh,g.cN,g.o_,u.qT,u.cb,u.cV,F.oV,I.q],styles:[".privilege-content[_ngcontent-%COMP%]   mat-slide-toggle[_ngcontent-%COMP%]{margin:8px 0}.text-primary[_ngcontent-%COMP%]{color:#1976d2}"]})}}return e})();var et=r(35317),ot=r(74061),nt=r(43655),it=r(53007),rt=r(15551),$=r(86467),ct=r(82765),C=r(59115),st=r(75063),E=r(82798),at=r(86600);function lt(e,i){if(1&e&&(t.j41(0,"mat-option",20),t.EFF(1),t.k0s()),2&e){const o=i.$implicit;t.Y8G("value",o.id),t.R7$(1),t.SpI(" ",o.name," ")}}function mt(e,i){1&e&&t.nrm(0,"mat-header-cell",21)}function ut(e,i){if(1&e&&(t.j41(0,"mat-cell",21)(1,"mat-checkbox",22),t.bIt("click",function(n){return n.stopPropagation()}),t.k0s()()),2&e){const o=i.$implicit;t.R7$(1),t.Y8G("disabled",!0)("checked",o.checked)}}function ft(e,i){if(1&e&&(t.j41(0,"mat-header-cell"),t.EFF(1),t.k0s()),2&e){const o=t.XpG(2).$implicit;t.R7$(1),t.JRh(o.name)}}function dt(e,i){if(1&e&&(t.j41(0,"mat-cell"),t.EFF(1),t.k0s()),2&e){const o=i.$implicit,n=t.XpG(2).$implicit;t.R7$(1),t.JRh(o[n.property])}}function pt(e,i){if(1&e&&(t.qex(0,24),t.DNE(1,ft,2,1,"mat-header-cell",25),t.DNE(2,dt,2,1,"mat-cell",18),t.bVm()),2&e){const o=t.XpG().$implicit;t.Y8G("matColumnDef",o.property)}}function ht(e,i){if(1&e&&(t.qex(0),t.DNE(1,pt,3,1,"ng-container",23),t.bVm()),2&e){const o=i.$implicit;t.R7$(1),t.Y8G("ngIf",o.isModelProperty)}}const D=function(){return{width:"100px"}};function gt(e,i){1&e&&t.nrm(0,"mat-header-cell",29),2&e&&t.Aen(t.lJ4(2,D))}function Ct(e,i){if(1&e&&(t.j41(0,"mat-icon",37),t.EFF(1),t.k0s()),2&e){const o=t.XpG().$implicit;t.R7$(1),t.JRh(o.icon)}}function vt(e,i){if(1&e){const o=t.RV6();t.j41(0,"button",35),t.bIt("click",function(){const a=t.eBV(o).$implicit,s=t.XpG().$implicit,m=t.XpG(2);return t.Njj(m.rowOptionClick(s,a.actionCode))}),t.DNE(1,Ct,2,1,"mat-icon",36),t.EFF(2),t.k0s()}if(2&e){const o=i.$implicit;t.R7$(1),t.Y8G("ngIf",o.icon),t.R7$(1),t.SpI("",o.action," ")}}function At(e,i){if(1&e&&(t.j41(0,"mat-cell",30)(1,"button",31),t.bIt("click",function(n){return n.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",32,33),t.DNE(6,vt,3,2,"button",34),t.k0s()()),2&e){const o=t.sdS(5),n=t.XpG(2);t.Aen(t.lJ4(4,D)),t.R7$(1),t.Y8G("matMenuTriggerFor",o),t.R7$(5),t.Y8G("ngForOf",n.rowActions)}}function yt(e,i){1&e&&(t.qex(0,26),t.DNE(1,gt,1,3,"mat-header-cell",27),t.DNE(2,At,7,5,"mat-cell",28),t.bVm())}function bt(e,i){1&e&&t.nrm(0,"mat-header-row",38)}function Rt(e,i){1&e&&t.nrm(0,"mat-row")}function _t(e,i){if(1&e&&(t.j41(0,"mat-cell")(1,"strong"),t.EFF(2),t.k0s()()),2&e){const o=i.$implicit;t.R7$(2),t.JRh(o.name)}}function xt(e,i){1&e&&t.nrm(0,"mat-row")}const Ft=function(){return["Seguridad"]},It=function(){return["groupHeader"]},$t=[{path:"",component:(()=>{class e{get visibleColumns(){return this.columns.filter(o=>o.visible).map(o=>o.property)}constructor(o,n,c){this.sidenavService=o,this.matDialog=n,this.apiClient=c,this.rowActions=[],this.userActions={},this.isGroupItem=(s,m)=>!!m.isParent,this.successActionList=s=>{this.userActions=s,this.rowActions=this.buildRowActions(),0===this.rowActions.length&&(this.columns=this.columns.filter(m=>"actions"!==m.property))},this.tableActionManager=s=>{"ROW_CLICK"===s.event&&this.rowActionEvent(s.data)},this.serviceError=s=>{console.error("ERROR: ",s)},this.buildRowActions=()=>{const s=[];return s.push({action:"Configurar Acciones",actionCode:this.commonTableActions.actionConfigCode,icon:"edit"}),s},this.buildColumns=()=>[{name:"Check",property:"checkbox",visible:!0,isModelProperty:!1},{name:"Nombre",property:"name",visible:!0,isModelProperty:!0},{name:"Url",property:"url",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0,isModelProperty:!1}],this.dataSource=new l.I6([]),this.roleControl=new u.MJ(null,u.k0.required),this.commonTableActions={actionConfigCode:"100"},this.columns=this.buildColumns(),this.apiClient.getRequest("/api/role",{page:0,size:1e3}).subscribe({next:s=>this.roleList=s,error:this.serviceError})}ngOnInit(){this.apiClient.getRequest("/api/v1/resource/actions-by-user?frontendCode=PAGE_ACCESOS").subscribe({next:this.successActionList})}rowOptionClick(o,n){this.rowActionEvent({actionCode:n,item:o})}roleSelected(){this.roleControl.valid&&this.apiClient.getRequest(`/api/role/access-list?roleId=${this.roleControl.value}`).subscribe({next:o=>this.dataSource.data=o,error:this.serviceError})}rowActionEvent(o){const{item:n,actionCode:c}=o;c===this.commonTableActions.actionConfigCode&&this.roleResourcePrivilegesConfig(n).then(console.log)}roleResourcePrivilegesConfig(o){var n=this;return(0,T.A)(function*(){const c=yield n.apiClient.getRequest(`/api/v1/action/find-available-by-resource?resourceId=${o.resourceId}`).toPromise().catch(n.serviceError);if(c){const a=yield n.apiClient.getRequest(`/api/v1/action/privileges-by-role-and-resource?resourceId=${o.resourceId}&roleId=${n.roleControl.value}`).toPromise().catch(n.serviceError);if(a){const m={roleId:n.roleControl.value,resourceId:o.resourceId,actionList:c,privilegeList:a};console.log(m),n.matDialog.open(tt,{width:"400px",height:"100%",autoFocus:!1,disableClose:!0,position:{right:"0"},data:m}).afterClosed().subscribe(wt=>{wt&&(n.roleSelected(),n.sidenavService.reloadResources())})}}})()}static{this.\u0275fac=function(n){return new(n||e)(t.rXU(et.S),t.rXU(p.bZ),t.rXU(_.f))}}static{this.\u0275cmp=t.VBU({type:e,selectors:[["mc4-access"]],decls:24,vars:13,consts:[["mode","card"],["current","Accesos",3,"crumbs"],["name","Accesos"],["fxLayout","row wrap"],["fxFlex","33",1,"m5"],[3,"appearance"],[3,"formControl","selectionChange"],[3,"value",4,"ngFor","ngForOf"],["fxFlex","100"],[3,"dataSource"],["matColumnDef","checkbox"],["class","check-cell",4,"matHeaderCellDef"],["class","check-cell",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions",4,"ngIf"],["mat-header-row","",4,"matHeaderRowDef"],[4,"matRowDef","matRowDefColumns"],["matColumnDef","groupHeader"],[4,"matCellDef"],[4,"matRowDef","matRowDefColumns","matRowDefWhen"],[3,"value"],[1,"check-cell"],["color","primary",3,"disabled","checked","click"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],[4,"matHeaderCellDef"],["matColumnDef","actions"],["class","actions-cell",3,"style",4,"matHeaderCellDef"],["class","actions-cell","fxLayoutAlign","end center",3,"style",4,"matCellDef"],[1,"actions-cell"],["fxLayoutAlign","end center",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu1","matMenu"],["mat-menu-item","",3,"click",4,"ngFor","ngForOf"],["mat-menu-item","",3,"click"],["color","primary",4,"ngIf"],["color","primary"],["mat-header-row",""]],template:function(n,c){1&n&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2)(5,"div",3)(6,"div",4)(7,"mat-form-field",5)(8,"mat-label"),t.EFF(9,"Seleccione un rol"),t.k0s(),t.j41(10,"mat-select",6),t.bIt("selectionChange",function(){return c.roleSelected()}),t.DNE(11,lt,2,2,"mat-option",7),t.k0s()()(),t.j41(12,"div",8)(13,"mat-table",9),t.qex(14,10),t.DNE(15,mt,1,0,"mat-header-cell",11),t.DNE(16,ut,2,2,"mat-cell",12),t.bVm(),t.DNE(17,ht,2,1,"ng-container",13),t.DNE(18,yt,3,0,"ng-container",14),t.DNE(19,bt,1,0,"mat-header-row",15),t.DNE(20,Rt,1,0,"mat-row",16),t.qex(21,17),t.DNE(22,_t,3,1,"mat-cell",18),t.bVm(),t.DNE(23,xt,1,0,"mat-row",19),t.k0s()()()()()()),2&n&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(11,Ft)),t.R7$(5),t.Y8G("appearance","outline"),t.R7$(3),t.Y8G("formControl",c.roleControl),t.R7$(1),t.Y8G("ngForOf",c.roleList),t.R7$(2),t.Y8G("dataSource",c.dataSource),t.R7$(4),t.Y8G("ngForOf",c.columns),t.R7$(1),t.Y8G("ngIf",c.rowActions),t.R7$(1),t.Y8G("matHeaderRowDef",c.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",c.visibleColumns),t.R7$(3),t.Y8G("matRowDefColumns",t.lJ4(12,It))("matRowDefWhen",c.isGroupItem))},dependencies:[d.Sq,d.bT,ot.m,nt.T,it.M,rt.M,f.DJ,f.sA,f.UI,$.rl,$.nJ,x.An,h.iY,ct.So,C.kk,C.fb,C.Cp,st.s,E.VO,at.wT,u.BC,u.l_,l.Zl,l.tL,l.ji,l.cC,l.YV,l.iL,l.KS,l.$R,l.YZ,l.NB],styles:[".mat-cell.check-cell[_ngcontent-%COMP%], .mat-header-cell.check-cell[_ngcontent-%COMP%]{flex:.1;width:70px;overflow:visible}"]})}}return e})()}];let Et=(()=>{class e{static{this.\u0275fac=function(n){return new(n||e)}}static{this.\u0275mod=t.$C({type:e})}static{this.\u0275inj=t.G2t({imports:[A.iI.forChild($t),A.iI]})}}return e})();var Dt=r(26924),Tt=r(96695),Gt=r(35823),Nt=r(60858),Pt=r(91398);let jt=(()=>{class e{static{this.\u0275fac=function(n){return new(n||e)}}static{this.\u0275mod=t.$C({type:e})}static{this.\u0275inj=t.G2t({imports:[d.MD,Et,Gt.Y,Nt.H,Dt.YF,Pt.H,E.Ve,u.YN,u.X1,l.tP,Tt.Ou,p.hM,F.uc,I.w]})}}return e})()}}]);